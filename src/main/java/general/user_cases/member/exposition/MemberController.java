package general.user_cases.member.exposition;

import general.kernel.CommandBus;
import general.user_cases.member.application.ApplyForMembership;
import general.user_cases.member.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MemberController {

    private final CommandBus commandBus;
    private static final String members = "/members";

    public MemberController(CommandBus commandBus) {
        this.commandBus = commandBus;
    }


    @PostMapping(path = members, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody @Valid MemberRequest request) {
        ApplyForMembership applyForMembership = new ApplyForMembership(new MemberName(request.memberName), new Company(request.company.name,new CompanyId(request.company.id)), new Subscription(request.memberShipType), request.paymentType);
        MemberId memberId = commandBus.send(applyForMembership);
        return ResponseEntity.created(URI.create(members + memberId.getValue())).build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
