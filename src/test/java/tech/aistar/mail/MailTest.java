package tech.aistar.mail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;

/**
 * @author:马立皓
 * @time:14:44 2022/7/4
 */
@SpringBootTest
public class MailTest {
    @Resource
    private JavaMailSender sender;

    @Test
    public void testSend(){
        //使用一个对象，来封装邮件的信息
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        //发送方-此处配置的邮件一定要和application-dev.yml中配置的username对应的又想保持一致
        simpleMailMessage.setFrom("1976886491@qq.com");
        //邮箱的标题 - 主题
        simpleMailMessage.setSubject("皇家学院");
        //邮箱的正文 - 随机的验证码
        simpleMailMessage.setText("99999");
        //收件方
        simpleMailMessage.setTo("1976886491@qq.com");
        //发送
        sender.send(simpleMailMessage);
    }
}
