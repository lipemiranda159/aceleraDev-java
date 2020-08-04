package challenge;

import org.springframework.stereotype.Service;

import java.util.Random;
@Service
public class NumberGeneratorServiceImpl implements NumberGeneratorService {

    private Random generator;

    public NumberGeneratorServiceImpl() {
        this.generator = new Random();
    }


    @Override
    public Integer GetNumber(Integer max) {
        return generator.nextInt(max);
    }
}
