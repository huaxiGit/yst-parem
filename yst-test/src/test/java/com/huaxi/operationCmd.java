package com.huaxi;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author zhanghuaxi
 * @author Administrator
 * @program:
 * @description:
 * @date 2021-03-08 13:25:19
 */
public class operationCmd {
    public static void main(String[] args) throws IOException {
        ProcessBuilder cmd = new ProcessBuilder("cmd", "/c", "ipconfig");
        Process start = cmd.start();
        Scanner scanner=new Scanner(start.getInputStream());
        while (scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
        }
        scanner.close();

    }
}
