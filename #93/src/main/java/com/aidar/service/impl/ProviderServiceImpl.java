package com.aidar.service.impl;

import com.aidar.model.Delivery;
import com.aidar.model.Office;
import com.aidar.model.Provider;
import com.aidar.repository.DeliveryRepository;
import com.aidar.repository.ProviderRepository;
import com.aidar.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    @Qualifier("providerRepository")
    private ProviderRepository providerRepository;

    @Autowired
    @Qualifier("deliveryRepository")
    private DeliveryRepository deliveryRepository;

    @Override
    public boolean hasDelivered(Office office, String name) {
        Provider provider = providerRepository.findByNameAndOffice(name, office);
        if (office == null || provider == null) {
            return false;
        }
        List<Delivery> deliveries = deliveryRepository.findByOfficeAndProvider(office, provider);
        Iterator<Delivery> it = deliveries.listIterator();
        while (it.hasNext()) {
            Delivery delivery = it.next();
            if (delivery.getEndDate() == null) {
                return false;
            }
        }
        return true;
    }

}
