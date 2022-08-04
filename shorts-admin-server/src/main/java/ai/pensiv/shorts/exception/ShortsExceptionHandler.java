package ai.pensiv.shorts.exception;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Map;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
//@Slf4j
public class ShortsExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = ShortsException.class)
    public ResponseEntity<Object> handle(ShortsException ex, WebRequest request) {
//        log.warn(appendWarnMessages(ex, request));
        ShortsResponseMessage apiError = new ShortsResponseMessage(
                StringUtils.isNoneBlank(Integer.toString(ex.getCode())) ? ShortsResponseMessage.BAD_REQUEST : ex.getCode(),
                "invalid request"); //ex.getLocalizedMessage()
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<Object> handle(RuntimeException ex, WebRequest request) {
//        log.warn(appendWarnMessages(ex, request));
        ShortsResponseMessage apiError = new ShortsResponseMessage(
                ShortsResponseMessage.BAD_REQUEST,
                "invalid request"); //ex.getLocalizedMessage()
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handle(Exception ex, WebRequest request) {
//        log.warn(appendWarnMessages(ex, request));
        ShortsResponseMessage apiError = new ShortsResponseMessage(
                ShortsResponseMessage.SERVER_ERROR,
                "Internal Server Error"); //ex.getLocalizedMessage()
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private String appendWarnMessages(Throwable ex, WebRequest request){
        StringBuilder warnMessages = new StringBuilder();

        if (ex.getMessage() != null) {
            warnMessages.append(ex.getLocalizedMessage()).append("\n");
        }

        if (ex.getCause() != null) {
            warnMessages.append(ex.getCause()).append("\n");
        }

        warnMessages.append(((ServletWebRequest) request).getRequest().getRequestURI()).append("\n");
        Map<String, String[]> params = request.getParameterMap();
        if (!params.isEmpty()) {
            for (String key : params.keySet()) {
                String[] values = params.get(key);
                warnMessages.append(key + ":" + values[0]).append("\n");
            }
        }

        StackTraceElement[] stacks = ex.getCause().getStackTrace();
        for (StackTraceElement element : stacks) {
            warnMessages.append(element.toString()).append("\n");
        }

        return warnMessages.toString();
    }
}
