package com.yupi.yuojcodesandbox.nativecode;

import com.yupi.yuojcodesandbox.model.ExecuteCodeRequest;
import com.yupi.yuojcodesandbox.model.ExecuteCodeResponse;
import com.yupi.yuojcodesandbox.template.PythonCodeSandboxTemplate;

import cn.hutool.core.io.resource.ResourceUtil;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import org.springframework.stereotype.Component;

/**
 * Java 原生代码沙箱实现（直接复用模板方法）
 */
@Component
public class PythonNativeCodeSandbox extends PythonCodeSandboxTemplate {

        public static void main(String[] args) {
        PythonNativeCodeSandbox pythonNativeCodeSandbox = new PythonNativeCodeSandbox();
        ExecuteCodeRequest executeCodeRequest = new ExecuteCodeRequest();
        executeCodeRequest.setInputList(Arrays.asList("1 -1", "1 35", "-5 -9"));
        String code = ResourceUtil.readStr("testCode/simpleComputePython/test1.py", StandardCharsets.UTF_8);
//        String code = ResourceUtil.readStr("testCode/unsafeCode/RunFileError.java", StandardCharsets.UTF_8);
//        String code = ResourceUtil.readStr("testCode/simpleCompute/Main.java", StandardCharsets.UTF_8);
        executeCodeRequest.setCode(code);
        executeCodeRequest.setLanguage("python");
        ExecuteCodeResponse executeCodeResponse = pythonNativeCodeSandbox.executeCode(executeCodeRequest);
        System.out.println(executeCodeResponse);
    }


    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        return super.executeCode(executeCodeRequest);
    }
}
