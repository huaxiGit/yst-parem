package test;


import com.yst.utilts.CodeEnum;
import com.yst.utilts.R;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author zhanghuaxi
 * @title: code
 * @projectName yst-parem
 * @description: TODO
 * @date 2021/1/24下午5:46
 */
@Slf4j
public class code {
    Logger logger =  LoggerFactory.getLogger(getClass());
    @Test
    public void eee(){

        //System.out.println( R.SUCCESS(CodeEnum.FAIL,"dfsdfdsffffff"));
       // System.out.println(R.ok("ddddd"));
        logger.info("我要要查看log4");
    }
}
