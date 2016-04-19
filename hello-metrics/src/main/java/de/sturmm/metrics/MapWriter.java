package de.sturmm.metrics;

import com.codahale.metrics.Counter;
import com.codahale.metrics.MetricRegistry;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.Metric;
import org.springframework.boot.actuate.metrics.export.Exporter;
import org.springframework.boot.actuate.metrics.repository.MetricRepository;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.SortedMap;

/**
 * Created by sturmm on 19.04.16.
 */
@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MapWriter implements Exporter {

    final MetricRegistry metricRepository;

    @Override
    public void export() {
        final SortedMap<String, Counter> all = metricRepository.getCounters();

        for (Map.Entry<String, Counter> metric : all.entrySet()) {
            System.out.println(String.format("%s: %s", metric.getKey(), metric.getValue().getCount()));
        }
    }
}
