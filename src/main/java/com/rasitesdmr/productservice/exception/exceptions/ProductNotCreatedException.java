package com.rasitesdmr.productservice.exception.exceptions;

import com.rasitesdmr.productservice.enums.Language;
import com.rasitesdmr.productservice.exception.enums.FriendlyMessageCode;
import com.rasitesdmr.productservice.exception.utils.FriendlyMessageUtils;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class ProductNotCreatedException extends RuntimeException{
    private final Language language;
    private final FriendlyMessageCode friendlyMessageCode;

    public ProductNotCreatedException(Language language , FriendlyMessageCode friendlyMessageCode ,String message){
        super(FriendlyMessageUtils.getFriendlyMessage(language, friendlyMessageCode));
        this.language = language;
        this.friendlyMessageCode = friendlyMessageCode;
        log.error("[ProductNotCreatedException] -> message: {} developer message: {}",FriendlyMessageUtils.getFriendlyMessage(language,friendlyMessageCode),message);

    }
}
