package org.springframework.samples.petclinic.recoveryroom;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class RecoveryRoomTypeFormatter implements Formatter<RecoveryRoomType>{

    RecoveryRoomService recoveryRoomService;
    @Override
    public String print(RecoveryRoomType object, Locale locale) {
        return object.getName();
    }

    @Override
    public RecoveryRoomType parse(String text, Locale locale) throws ParseException {
        Collection<RecoveryRoomType> findRecoveryRoomTypes=recoveryRoomService.getAllRecoveryRoomTypes();
        for (RecoveryRoomType recoveryRoomType : findRecoveryRoomTypes) {
            if(recoveryRoomType.getName().equals(text)) return recoveryRoomType;
        }
        throw new ParseException("room type not found: " + text, 0);
    }
    
}
