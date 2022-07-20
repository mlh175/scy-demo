package tech.aistar.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import tech.aistar.moudle.pojo.Nucleic;

import java.util.List;

/**
 * @author:马立皓
 * @time:21:06 2022/7/7
 */
@SpringBootTest
public class INucleicServiceTest {
    //自动注入INucleicService对象
    @Autowired
    private INucleicService iNucleicService;
    @Test
    public void test(){
        PageRequest pageRequest = PageRequest.of(0, 3);
        Page<Nucleic> m = iNucleicService.findByUserNameContainsOrderByIdDesc("m", pageRequest);
        List<Nucleic> content = m.getContent();
        content.forEach(nucleic -> System.out.println(nucleic));

    }

}
