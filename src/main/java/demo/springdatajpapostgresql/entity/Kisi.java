package demo.springdatajpapostgresql.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Table(name = "kisi")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"}) //İki tane adres nesnesi'nin id'leri eşitse ikisi aynı nesnedir.
@ToString
public class Kisi {

    @Id
    @SequenceGenerator(name = "seq_kisi",allocationSize = 1)
    @GeneratedValue(generator = "seq_kisi",strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(length = 500,name = "adi")
    private String adi;

    @Column(length = 500,name = "soyadi")
    private String soyadi;

    @OneToMany //Bir kişi bir adresi atabilir.
    @JoinColumn(name = "kisi_adres_id")
     private List<Adres> adresleri;




}
