package demo.springdatajpapostgresql.entity;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "kisi_adres")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"}) //İki tane adres nesnesi'nin id'leri eşitse ikisi aynı nesnedir.
@ToString
public class Adres implements Serializable { //Serializable herhangi bir sınıfta nesne üretip dosya içerisine
                                            //saklayıp,daha sonra ihtiyacımız olduğunda okumamızı sağlıyor
                                            //Depolama diyebiliriz.


    @Id
    @SequenceGenerator(name = "seq_kisi_adres",allocationSize = 1)
    @GeneratedValue(generator = "seq_kisi_adres",strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 500,name = "adres")
    private String adres;

    @Enumerated
    private AdresTip adresTip;

    @Column(name = "aktif")
     private Boolean aktif;

    @ManyToOne
    @JoinColumn(name = "kisi_adres_id" )
    private Kisi kisi;



   public enum AdresTip {
        EV_ADRESI,
        IS_ADRESI,
        DIGER
    }

}
