//package dziedziczenie.cw4;
//
//import java.math.BigInteger;
//
//class KontoStudenckie  extends  Konto{
//    BigInteger srodki; // 2 ostatnie liczby to grosze
//    BigInteger oprocentowanie = new BigInteger("25");
//    int kapitalizacja = 12;// ilosc miesiecy po ktorych nastepuje kapitalizacja
//    BigInteger oplata_za_prowadzenie = new BigInteger("0");
//    BigInteger podatek_belki = new BigInteger("19");
//
//    KontoStudenckie(BigInteger poczatkowe_srodki){
//        super();
//        this.srodki = poczatkowe_srodki;
//    }
//
//    @Override
//    BigInteger zyskPoCzasie(int ilosc_miesiecy)
//    {
//        int i = 1;
//        BigInteger kasa = srodki;
//        while (i  <= ilosc_miesiecy)
//        {
//            if (i%kapitalizacja == 0)
//            {
//                BigInteger ods = odsetki(kasa);
//                ods = ods.subtract(kwotaPodatku(ods));
//                kasa = kasa.add(ods);
//            }
//            i++;
//        }
//        return kasa;
//    }
//
//    public BigInteger odsetki(BigInteger ilosc_gotowki){
//
//        return ilosc_gotowki.multiply(oprocentowanie).divide(new BigInteger("100"));
//    }
//    public BigInteger kwotaPodatku(BigInteger odsetki){
//        return odsetki.multiply(podatek_belki).divide(new BigInteger("100"));
//    }
//
//    public String toString(){
//        return this.srodki.toString();
//    }
//}
