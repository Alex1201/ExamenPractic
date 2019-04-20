package Tests;

import Domain.Car;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    Car A = new Car("1","aa",12,10);

    @org.junit.jupiter.api.Test
    void equals() {
        assertEquals(true,A.equals(A));
    }

//    @org.junit.jupiter.api.Test
//    int hashCode() {
//        assertEquals(true,A.hashCode() == A.hashCode());
//    }

    @org.junit.jupiter.api.Test
    void toString() {
    }

    @org.junit.jupiter.api.Test
    void getId() {
    }

    @org.junit.jupiter.api.Test
    void getId1() {
    }

    @org.junit.jupiter.api.Test
    void setId() {
    }

    @org.junit.jupiter.api.Test
    void getModel() {
    }

    @org.junit.jupiter.api.Test
    void setModel() {
    }

    @org.junit.jupiter.api.Test
    void getKm() {
    }

    @org.junit.jupiter.api.Test
    void setKm() {
    }

    @org.junit.jupiter.api.Test
    void getPrice() {
    }

    @org.junit.jupiter.api.Test
    void setPrice() {
    }

    @org.junit.jupiter.api.Test
    void hashCode1() {
    }
}