package softuni.bg.Gira.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.bg.Gira.model.entity.Classification;
import softuni.bg.Gira.model.enums.ClassificationName;
import softuni.bg.Gira.repo.ClassificationRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ClassificationInit implements CommandLineRunner {
    private final ClassificationRepository classificationRepository;

    public ClassificationInit(ClassificationRepository classificationRepository) {
        this.classificationRepository = classificationRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(this.classificationRepository.count() == 0){
            List<Classification> classificationList = new ArrayList<>();

            Arrays.stream(ClassificationName.values())
                    .forEach(classificationName -> {
                        Classification classification = new Classification();
                        classification.setName(classificationName);
                        classification.setDescription(classificationName.toString());
                        classificationList.add(classification);
                    });
            this.classificationRepository.saveAll(classificationList);
        }
    }
}
