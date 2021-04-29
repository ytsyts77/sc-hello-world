package com.samsungcard.helloworld;

import com.samsungcard.helloworld.sample.emp.entity.Dept;
import com.samsungcard.helloworld.sample.emp.entity.Emp;
import com.samsungcard.helloworld.sample.emp.repository.DeptRepository;
import com.samsungcard.helloworld.sample.emp.repository.EmpRepository;
import com.samsungcard.helloworld.sample.file.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@SpringBootApplication(scanBasePackageClasses = {ComponentScanBasePackage.class})
public class HelloWorldApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloWorldApplication.class, args);
    }

    @Bean
    ApplicationRunner init(StorageService storageService) {
        return args -> {
            storageService.deleteAll();
            storageService.init();
        };
    }

    @Bean
    ApplicationRunner init() {
        return args -> log.info("Hello World");
    }

    @Bean
    ApplicationRunner printArgs() {
        return args -> Arrays.stream(args.getSourceArgs()).forEach(System.out::println);
    }

    @Bean
    ApplicationRunner makeSomeDataForTest(EmpRepository empRepository, DeptRepository deptRepository) {
        return args -> {
            Dept dept = Dept.builder()
                    .name("샘플 부서")
                    .build();

            deptRepository.save(dept);

            String[] names = {"로버트 다우니,주니어",
                    "크리스,에반스",
                    "마크,러팔로",
                    "크리스,헴스워스",
                    "스칼렛,요한슨",
                    "제레미,레너",
                    "돈,치들",
                    "폴,러드",
                    "브리,라슨",
                    "브래들리,쿠퍼",
                    "카렌,길런"};

            AtomicInteger i = new AtomicInteger(0);
            Arrays.stream(names)
                    .forEach(n -> {
                        String[] s = n.split(",");
                        empRepository.save(Emp.builder()
                                .firstName(s[0])
                                .lastName(s[1])
                                .email(String.format("emp%03d@samsungcard.com", i.incrementAndGet()))
                                .dept(dept)
                                .build());
                            }
                    );

            log.info(String.format("%,d sample data inserted.", i.get()));
        };
    }
}
