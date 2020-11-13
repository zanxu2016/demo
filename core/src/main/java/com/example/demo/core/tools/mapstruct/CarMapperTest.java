package com.example.demo.core.tools.mapstruct;

public class CarMapperTest {

    public static void main(String[] args) {
        //given
        Car car = new Car("Morris", 5, 2);

        //when
        CarDto carDto = CarMapper.INSTANCE.carToCarDto(car);
        System.out.println(carDto);
    }

}
