package com.zw.lib;

import com.google.auto.service.AutoService;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import com.zw.lib2.AnnTest;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.IOException;
import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeMirror;
import javax.tools.Diagnostic;

// 引入auto——service
//引入apt
//拦截注解器重新实现方法
@AutoService(Processor.class)
public class HelloProcess extends AbstractProcessor {

    private Filer filer;
    private final String subInterfaceUrl = "com.zw.myapplication.ItestInterface";

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        // Filer是个接口，支持通过注解处理器创建新文件
        filer = processingEnv.getFiler();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnvironment) {

        for (TypeElement element : annotations) {
            if (element.getQualifiedName().toString().equals(AnnTest.class.getCanonicalName())) {
                //获得被该注解声明的元素
                Set<? extends Element> elememts = roundEnvironment
                        .getElementsAnnotatedWith(AnnTest.class);

                TypeElement classElement = null;// 声明类元素
                List<VariableElement> fields = null;// 声明一个存放成员变量的列表
                // 存放二者
                Map<String, ClassName> maps = new HashMap<String, ClassName>();
                //List<String> valueAnntest = new ArrayList<String>();

                List<ClassName> classList = new ArrayList<ClassName>();
                for (Element ele : elememts) {

                    //valueAnntest.add(test.value());
//                    if(ele.getKind() == ElementKind.CLASS) {
//                        Element e = ele.getEnclosingElement();
//                        e.
//                        String className = e.getSimpleName().toString();
//                    }
                     /*检查类型*/
                    if (!(ele instanceof TypeElement)) {
                        return false;
                    }
                    AnnTest test = ele.getAnnotation(AnnTest.class);
                    String value = test.value();
                    TypeElement t = (TypeElement) ele;
                    //t.getInterfaces()
                    List<? extends TypeMirror> subinterface = t.getInterfaces();
                    //List<? extends >t.getInterfaces();
                    String path = t.getQualifiedName().toString();
                    String simpleName = t.getSimpleName().toString();
                    ClassName clss = ClassName.bestGuess(path);
                    maps.put(value, clss);
                    classList.add(clss);
                }
                try {
                    if (maps != null && maps.size() > 0) {

                        StringBuilder builder = new StringBuilder();
                        String code = "com.zw.myapplication.ItestInterface imp = null;" + "\n";
                        code += "switch(channel){" + "\n";
                        Iterator<Map.Entry<String, ClassName>> map = maps.entrySet().iterator();
                        while (map.hasNext()) {
                            Map.Entry<String, ClassName> mapEntry = map.next();
                            code += "case " + "\"" + mapEntry.getKey() + "\"" + ":" + "\n"
                                    + "imp = new " + mapEntry.getValue() + "();\n"
                                    + "break;" + "\n";
                        }
                        code += "}" + "\n";
                        code += "return imp;" + "\n";
                        MethodSpec main = MethodSpec.methodBuilder("main")
                                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                                .returns(ClassName.bestGuess("com.zw.myapplication.ItestInterface"))
                                //.returns(void.class)
                                .addParameter(String.class, "channel")
                                //.addStatement("$T.out.println($S)", System.class, code)
                                //.addStatement()
                                .addCode(code)
                                .build();
                        //                // 创建HelloWorld类
                        TypeSpec helloWorld = TypeSpec.classBuilder("HelloWorld")
                                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                                .addMethod(main)
                                .build();
                        try {

                            // 生成 com.example.HelloWorld.java
                            JavaFile javaFile = JavaFile.builder("com.test", helloWorld)
                                    .addFileComment(" This codes are generated automatically. Do not modify!")
                                    //.addStaticImport()
                                    //.addStaticImport()
                                    .build();
                            //　生成文件
                            javaFile.writeTo(filer);
                        } catch (IOException e) {
                            e.printStackTrace();
                            System.out.println("============");
                            //}
                        }
                    }
                }catch(Exception e){

                }
            }
        }

//        for (TypeElement element : annotations) {
//            if (element.getQualifiedName().toString().equals(AnnTest.class.getCanonicalName())) {
//                // 创建main方法
//                MethodSpec main = MethodSpec.methodBuilder("main")
//                        .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
//                        .returns(void.class)
//                        .addParameter(String[].class, "args")
//                        .addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!")
//                        .build();
//                // 创建HelloWorld类
//                TypeSpec helloWorld = TypeSpec.classBuilder("HelloWorld")
//                        .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
//                        .addMethod(main)
//                        .build();
//
//                try {
//                    // 生成 com.example.HelloWorld.java
//                    JavaFile javaFile = JavaFile.builder("com.example", helloWorld)
//                            .addFileComment(" This codes are generated automatically. Do not modify!")
//                            .build();
//                    //　生成文件
//                    javaFile.writeTo(filer);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

        return true;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> annotations = new LinkedHashSet<>();
        annotations.add(AnnTest.class.getCanonicalName());
        return annotations;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

}
