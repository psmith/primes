package pw.pablo.primes.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pw.pablo.primes.models.Prime;

import javax.jws.WebMethod;
import java.math.BigInteger;
import java.util.SortedSet;

@RestController
public class PrimesApiController {

    @GetMapping("/primes/{number}")
    public Prime getPrime(@PathVariable(name = "number", required = true) BigInteger number){
        return new Prime(number,number.isProbablePrime(Integer.MAX_VALUE));
    }
}
