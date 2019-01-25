package zestaw4.cw4;
import java.math.BigInteger;

abstract class Konto implements  Podatek, Oprocentowanie{

    abstract BigInteger zyskPoCzasie(int ilosc_miesiecy);
}
