package kg.lalfo.lalafoservice.services.impl;

import kg.lalfo.lalafoservice.entities.RequestLogs;
import kg.lalfo.lalafoservice.repositories.RequestLogRepository;
import kg.lalfo.lalafoservice.services.RequestLogsService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RequestLogServiceImpl implements RequestLogsService {
    private final static Logger logger = LoggerFactory.getLogger(RequestLogServiceImpl.class);

    private final RequestLogRepository requestLogRepository;

    @Override
    public void create(RequestLogs requestLog) {
        logger.info("Request --> saving a request log");
        requestLogRepository.save(requestLog);
    }
}
