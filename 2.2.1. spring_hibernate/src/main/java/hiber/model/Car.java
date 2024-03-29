package hiber.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "cars")
public class Car {

    @Id
    @Column(name = "model")
    String model;

    @Column(name = "series")
    int series;

    public Car() {
    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return series == car.series && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, series);
    }

    @Override
    public String toString() {
        return "model = " + model + ", series = " + series;
    }

}
