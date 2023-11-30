package demo.springdatajpapostgresql.service;

import demo.springdatajpapostgresql.Iservice.IKisiService;
import demo.springdatajpapostgresql.dto.KisiDto;
import demo.springdatajpapostgresql.entity.Adres;
import demo.springdatajpapostgresql.entity.Kisi;
import demo.springdatajpapostgresql.repo.AdresRepository;
import demo.springdatajpapostgresql.repo.KisiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KisiService  implements IKisiService {

     private final KisiRepository  kisiRepository;
     private final AdresRepository adresRepository;

    @Override
    public KisiDto save(KisiDto kisiDto) {

        Kisi kisi = new Kisi();
        kisi.setAdi(kisiDto.getAdi());
        kisi.setSoyadi(kisiDto.getSoyadi());
        Kisi kisiDb = kisiRepository.save(kisi);

        List<Adres> liste = new ArrayList<>();
        kisiDto.getAdresleri().forEach(item -> {
            Adres adres = new Adres();
            adres.setAdres(item);
            adres.setAdresTip(Adres.AdresTip.DIGER);
            adres.setAktif(true);
            adres.setKisi(kisiDb);
            liste.add(adres);
        });
        adresRepository.saveAll(liste);
        kisiDto.setId(kisiDb.getId());
        return kisiDto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<KisiDto> getAll() {
        List<Kisi> kisiler = kisiRepository.findAll();
        List<KisiDto> kisiDtos = new ArrayList<>();
        kisiler.forEach(it -> {
            KisiDto kisiDto =new KisiDto();
            kisiDto.setId(it.getId());
            kisiDto.setAdi(it.getAdi());
            kisiDto.setSoyadi(it.getSoyadi());
            kisiDto.setAdresleri(
                    it.getAdresleri() != null ?
                            it.getAdresleri().stream().map(Adres::getAdres).collect(Collectors.toList())
                            : null);
            kisiDtos.add(kisiDto);
        });
        return kisiDtos ;
    }

    @Override
    public Page<KisiDto> getAll(Pageable pageable) {
        return null;
    }
}
