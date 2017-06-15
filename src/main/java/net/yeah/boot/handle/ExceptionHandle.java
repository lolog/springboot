package net.yeah.boot.handle;

import net.yeah.boot.exception.NdException;
import net.yeah.boot.pojo.Result;
import net.yeah.boot.pojo.Student;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionHandle {
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result handle (Exception e) {
        Result<Student> result = new Result<>();
        result.setCode(1);

        if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException ex = (MethodArgumentNotValidException) e;
            String message = ex.getBindingResult().getFieldError().getDefaultMessage();

            result.setMessage(message);
        }
        else if (e instanceof NdException) {
            result.setCode(((NdException) e).getCode());
            result.setMessage(e.getMessage());
        }

        return result;
    }

    @ResponseBody
    @ExceptionHandler(value = NoHandlerFoundException.class)
    public Result pageHandle (NoHandlerFoundException e) {
        Result<Student> result = new Result<>();

        result.setCode(1000);
        result.setMessage(e.getMessage());

        return result;
    }
}
