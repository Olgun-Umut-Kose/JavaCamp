package com.bgouk.Concrete.Adapters;

import com.bgouk.Abstract.ICustomerCheckService;
import com.bgouk.Concrete.Entities.Customer;
import com.bgouk.Services.Mernis.KPSPublic;
import com.bgouk.Services.Mernis.KPSPublicSoap;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Locale;

public class MernisAdapter implements ICustomerCheckService {
    private final String endpoint = "https://tckimlik.nvi.gov.tr/Service/KPSPublic.asmx";

    @Override
    public boolean Verify(Customer customer) throws MalformedURLException {
        URL url = URI.create(endpoint).toURL();
        KPSPublic service = new KPSPublic(url);
        KPSPublicSoap port = service.getPort(KPSPublicSoap.class);
        return port.tcKimlikNoDogrula(Long.parseLong(customer.getNationalityId()),customer.getFirstName().toUpperCase(Locale.ROOT),customer.getLastName().toUpperCase(Locale.ROOT),customer.getDateOfBirth().getYear());


    }
}
