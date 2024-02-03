package org.example;

import java.util.ArrayList;
import java.util.List;

class Personel {
    String ad;
    String soyad;
    String dogumTarihi;

    Personel(String ad, String soyad, String dogumTarihi) {
        this.ad = ad;
        this.soyad = soyad;
        this.dogumTarihi = dogumTarihi;
    }

    int hesaplaEmeklilikYasi() {
        return 0;
    }
}

class Erkek extends Personel {
    Erkek(String ad, String soyad, String dogumTarihi) {
        super(ad, soyad, dogumTarihi);
    }

    @Override
    int hesaplaEmeklilikYasi() {
        return 65;
    }
}

class Kadin extends Personel {
    Kadin(String ad, String soyad, String dogumTarihi) {
        super(ad, soyad, dogumTarihi);
    }

    @Override
    int hesaplaEmeklilikYasi() {
        return 60;
    }
}

class Departman {
    Erkek teamLead;
    List<Personel> personelList;
    List<String> assignmentList;

    Departman(Erkek teamLead) {
        this.teamLead = teamLead;
        this.personelList = new ArrayList<>();
        this.assignmentList = new ArrayList<>();
    }

    void teamLeadDegistir(Erkek yeniTeamLead) {
        this.teamLead = yeniTeamLead;
    }

    void personelEkle(Personel personel) {
        personelList.add(personel);
    }

    void personelCikar(Personel personel) {
        personelList.remove(personel);
    }

    void personelDegistir(Personel eskiPersonel, Personel yeniPersonel) {
        int index = personelList.indexOf(eskiPersonel);
        if (index != -1) {
            personelList.set(index, yeniPersonel);
        }
    }

    void gorevEkle(String gorev) {
        assignmentList.add(gorev);
    }

    void gorevTamamlandi(String tamamlananGorev) {
        assignmentList.remove(tamamlananGorev);
    }
}

public class Main {
    public static void main(String[] args) {
        Erkek teamLead = new Erkek("Serkan", "Cura", "01/10/1984");
        Departman departman = new Departman(teamLead);

        Kadin personel1 = new Kadin("Murat", "Bilim", "06/10/1988");
        departman.personelEkle(personel1);

        Erkek personel2 = new Erkek("Selçuk", "Seyyar", "01/03/1990");
        departman.personelEkle(personel2);

        departman.gorevEkle("IT Uzmanı");
        departman.gorevEkle("Mobil Yazılım Geliştirici");

        System.out.println("Team Lead: " + departman.teamLead.ad + " " + departman.teamLead.soyad);
        System.out.println("Personel Listesi: ");
        for (Personel personel : departman.personelList) {
            System.out.println(personel.ad + " " + personel.soyad);
        }
        System.out.println("Görevler: " + departman.assignmentList);
    }
}
