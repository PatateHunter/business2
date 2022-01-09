package general.user_cases.member.exposition;

import general.kernel.CommandBus;
import general.kernel.QueryBus;
import general.user_cases.member.application.ApplyForMembership;
import general.user_cases.member.domain.Company;
import general.user_cases.member.domain.CompanyId;
import general.user_cases.member.domain.MemberId;
import general.user_cases.member.domain.MemberName;
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
    private final QueryBus queryBus;

    public MemberController(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

  /*  @GetMapping(path = "/users", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UsersResponse> getAll() {
        final List<User> users = queryBus.send(new RetrieveUsers());
        UsersResponse usersResponseResult = new UsersResponse(users.stream().map(user -> new UserResponse(String.valueOf(user.getId().getValue()), user.getLastname(), user.getFirstname(), new AddressResponse(user.getAddress().getCity()))).collect(Collectors.toList()));
        return ResponseEntity.ok(usersResponseResult);
    }*/

    @PostMapping(path = "/members", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody @Valid MemberRequest request) {
        ApplyForMembership createUser = new ApplyForMembership(new MemberName(request.memberName.memberName), new Company(request.company.companyName,new CompanyId(request.company.companyId)), request.memberShipType);
        MemberId memberId = commandBus.send(createUser);
        return ResponseEntity.created(URI.create("/members/" + memberId.getValue())).build();
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
