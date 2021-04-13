import java.util.*;

class Auto_idopont {
    private String auto;
    private int ev1;
    private int honap1;
    private int nap1;
    private int ev2;
    private int honap2;
    private int nap2;

    public Auto_idopont(String auto, int ev1, int honap1, int nap1,
                        int ev2, int honap2, int nap2)
    {
        this.auto = auto;
        this.ev1 = ev1;
        this.honap1 = honap1;
        this.nap1 = nap1;
        this.ev2 = ev2;
        this.honap2 = honap2;
        this.nap2 = nap2;
    }

    public String getAuto() {
        return auto;
    }

    public int getEv1() {
        return ev1;
    }

    public int getHonap1() {
        return honap1;
    }

    public int getNap1() {
        return nap1;
    }

    public int getEv2() {
        return ev2;
    }

    public int getHonap2() {
        return honap2;
    }

    public int getNap2() {
        return nap2;
    }
}

public class datum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Auto_idopont> list = new ArrayList<>();
        int db = 0;
        int szamol = 0;

        while (sc.hasNextLine())
        {
            String sor = sc.nextLine();
            String[] tokens1 = sor.split(";");
            String[] tokens2 = tokens1[1].split("/");
            String[] tokens3 = tokens1[2].split("/");

            /*System.out.println(tokens1[0]);
            System.out.println(tokens1[1]);
            System.out.println(tokens1[2]);
            System.out.println();

            System.out.println(tokens2[0]);
            System.out.println(tokens2[1]);
            System.out.println(tokens2[2]);
            System.out.println();

            System.out.println(tokens3[0]);
            System.out.println(tokens3[1]);
            System.out.println(tokens3[2]);
            //mazda;2021.05.12.;2021.05.22.
            //mazda;2021/05/12;2021/05/22*/

            if (db == 0)
            {
                Auto_idopont a = new Auto_idopont(tokens1[0], Integer.parseInt(tokens2[0]),
                        Integer.parseInt(tokens2[1]), Integer.parseInt(tokens2[2]), Integer.parseInt(tokens3[0]),
                        Integer.parseInt(tokens3[1]), Integer.parseInt(tokens3[2]));
                list.add(a);
                db++;
                szamol++;
                System.out.println("Az autofoglalas sikeres!");

                for (int i = 0; i < szamol; i++)
                {
                    System.out.println();
                    System.out.println("Auto: " + list.get(i).getAuto());
                    System.out.println("Foglalas kezdete: " + list.get(i).getEv1() + "."
                            + list.get(i).getHonap1() + "." + list.get(i).getNap1() + ".");
                    System.out.println("Foglalas vege: " + list.get(i).getEv2() + "."
                            + list.get(i).getHonap2() + "." + list.get(i).getNap2() + ".");
                }
            }else{
                int ilyen_nincs = 0;
                for (int i = 0; i < szamol; i++)
                {
                    if (list.get(i).getAuto().equals(tokens1[0]))
                    {
                        if ((list.get(i).getEv1() <= Integer.parseInt(tokens2[0])) &&
                                (list.get(i).getEv2() >= Integer.parseInt(tokens2[0])))
                        {
                            if ((list.get(i).getHonap1() <= Integer.parseInt(tokens2[1])) &&
                                    (list.get(i).getHonap2() >= Integer.parseInt(tokens2[1])))
                            {
                                if ((list.get(i).getNap1() <= Integer.parseInt(tokens2[2])) &&
                                        (list.get(i).getNap2() >= Integer.parseInt(tokens2[2])))
                                {
                                    ilyen_nincs++;
                                }
                            }
                        }
                        if ((list.get(i).getEv1() <= Integer.parseInt(tokens3[0])) &&
                                (list.get(i).getEv2() >= Integer.parseInt(tokens3[0])))
                        {
                            if ((list.get(i).getHonap1() <= Integer.parseInt(tokens3[1])) &&
                                    (list.get(i).getHonap2() >= Integer.parseInt(tokens3[1])))
                            {
                                if ((list.get(i).getNap1() <= Integer.parseInt(tokens3[2])) &&
                                        (list.get(i).getNap2() >= Integer.parseInt(tokens3[2])))
                                {
                                    ilyen_nincs++;
                                }
                            }
                        }
                        //ha a ket datum nagyobb intervallum
                        if ((list.get(i).getEv1() >= Integer.parseInt(tokens2[0])) &&
                                (list.get(i).getEv2() <= Integer.parseInt(tokens3[0])))
                        {
                            if ((list.get(i).getHonap1() >= Integer.parseInt(tokens2[1])) &&
                                    (list.get(i).getHonap2() <= Integer.parseInt(tokens3[1])))
                            {
                                if ((list.get(i).getNap1() >= Integer.parseInt(tokens2[2])) &&
                                        (list.get(i).getNap2() <= Integer.parseInt(tokens3[2])))
                                {
                                    ilyen_nincs++;
                                }
                            }
                        }
                    }

                }

                if (ilyen_nincs == 0)
                {
                    Auto_idopont a = new Auto_idopont(tokens1[0], Integer.parseInt(tokens2[0]),
                            Integer.parseInt(tokens2[1]), Integer.parseInt(tokens2[2]), Integer.parseInt(tokens3[0]),
                            Integer.parseInt(tokens3[1]), Integer.parseInt(tokens3[2]));
                    list.add(a);
                    szamol++;
                    System.out.println("Az autofoglalas sikeres!");

                    for (int i = 0; i < szamol; i++)
                    {
                        System.out.println();
                        System.out.println("Auto: " + list.get(i).getAuto());
                        System.out.println("Foglalas kezdete: " + list.get(i).getEv1() + "."
                                + list.get(i).getHonap1() + "." + list.get(i).getNap1() + ".");
                        System.out.println("Foglalas vege: " + list.get(i).getEv2() + "."
                                + list.get(i).getHonap2() + "." + list.get(i).getNap2() + ".");
                    }
                }else{
                    System.out.println("Uj idopontot kerek, mert ekkor mar foglalt. Az autofoglalas SIKERTELEN!");
                }
            }
        }
    }
}
