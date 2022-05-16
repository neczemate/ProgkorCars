package hu.nye.progkor.cars.model;


import java.util.Objects;

public class Car {

    private Long Id;

    private Model model;

    private double motor;

    private Equipment equipment;

    private double consumption;

    private Integer price;

    public Car() {

    }

    public Car(final Long Id, final Model model, final double motor, final Equipment equipment, final double consumption, final Integer price) {
        this.Id = Id;
        this.model = model;
        this.motor = motor;
        this.equipment = equipment;
        this.consumption = consumption;
        this.price = price;
    }

    public Long getId() {
        return Id;
    }

    public void setId(final Long Id) {
        this.Id = Id;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(final Model model) {
        this.model = model;
    }

    public double getMotor() {
        return motor;
    }

    public void setMotor(final double motor) {
        this.motor = motor;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(final Equipment equipment) {
        this.equipment = equipment;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(final double consumption) {
        this.consumption = consumption;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(final Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.motor, motor) == 0 && Objects.equals(Id, car.Id) && model == car.model && equipment == car.equipment && Objects.equals(consumption, car.consumption) && Objects.equals(price, car.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, model, motor, equipment, consumption, price);
    }
}
