package pw.pablo.primes.models;

//import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;

public class Prime implements Comparable<Prime>{
    //@Id
    @NotNull
    private BigInteger number;
    private boolean isPrime;
    //private BigInteger nthPrime;

    public Prime(BigInteger number, boolean isPrime) { // BigInteger nthPrime) {
        this.number = number;
        this.isPrime = isPrime;
        //this.nthPrime = nthPrime;
    }

    public BigInteger getNumber() {
        return number;
    }

    public boolean isPrime() {
        return isPrime;
    }

//    public BigInteger getNthPrime() {
//        return nthPrime;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prime prime = (Prime) o;
        return number.equals(prime.number);
    }

    @Override
    public int hashCode() {
        return number.hashCode();
    }

    @Override
    public String toString() {
        return "Prime{" +
                "number=" + number +
                ", isPrime=" + isPrime +
                '}';
    }

    @Override
    public int compareTo(Prime o) {
        return number.compareTo(o.getNumber());
    }
}
