package com.bgouk.Concrete.Adapters;

import com.bgouk.Abstract.IPersonCheckService;
import com.bgouk.Abstract.Person;
import com.bgouk.Services.Mernis.KPSPublic;
import com.bgouk.Services.Mernis.KPSPublicSoap;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;

public class MernisAdapter implements IPersonCheckService {
    private static final String endpoint = "https://tckimlik.nvi.gov.tr/Service/KPSPublic.asmx";


    @Override
    public boolean VerifyPerson(Person person) throws MalformedURLException {
        URL url = URI.create(endpoint).toURL();
        KPSPublic service = new KPSPublic(url);
        KPSPublicSoap port = service.getPort(KPSPublicSoap.class);
        return port.tcKimlikNoDogrula(Long.parseLong(person.getNationalityId()),person.getFirstName().toUpperCase(Locale.ROOT),person.getLastName().toUpperCase(Locale.ROOT),person.getDateOfBirth().getYear());

    }
}
