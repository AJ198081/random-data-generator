package dev.aj.randomdatagenerator.writeoperations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WriteOperationFactory {

    private final CSVOperations csvOperations;

    private final XmlOperations xmlOperations;

    private final JsonOperations jsonOperations;

    public WriteOperation getWriteOperation(WriteType operationType) {

        switch (operationType) {
            case XML:
                return xmlOperations;
            case JSON:
                return jsonOperations;
            default:
                return csvOperations;
        }
    }
}
