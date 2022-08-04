package ai.pensiv.shorts.controller;

import ai.pensiv.shorts.service.AccountService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired AccountService accountService;

//    @ApiOperation(value = "Search accounts")
//    @GetMapping(value = {"/api/v1/accounts"}, produces = "application/json;charset=UTF-8")
//    public ResponseEntity<Object> searchStates(
//            @RequestParam(defaultValue = "") String keyword,
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "10") int size,
//            @RequestParam(defaultValue = "name") String sort,
//            @RequestParam(defaultValue = "dsc") String direction) {
//        Pageable pageRequest = PageRequest.of(page, size, "dsc".equals(direction) ? Sort.by(sort).descending() : Sort.by(sort).ascending());
//        return ResponseEntity.ok(PaginationUtils.toMap(stateService.searchAll(keyword, pageRequest)));
//    }
//
//    @ApiOperation(value = "Create state")
//    @PostMapping(value = "/api/v1/state", produces = "application/json;charset=UTF-8")
//    public ResponseEntity<Object> createState(@RequestBody @Valid State state) {
//        return ResponseEntity.ok(stateService.save(state));
//    }
//
//    @ApiOperation(value = "Read state")
//    @GetMapping(value = "/api/v1/state/{code}", produces = "application/json;charset=UTF-8")
//    public ResponseEntity<Object> readState(@PathVariable String code) {
//        return ResponseEntity.ok(stateService.read(code));
//    }
//
//    @ApiOperation(value = "Update state")
//    @PutMapping(value = "/api/v1/state", produces = "application/json;charset=UTF-8")
//    public ResponseEntity<Object> updateState(@RequestBody @Valid State state) {
//        return ResponseEntity.ok(stateService.save(state));
//    }
//
//    // TODO: delete operation not need to be implemented
//    //       just change status if has status field
//    @ApiOperation(value = "Delete state")
//    @DeleteMapping(value = "/api/v1/state/{code}", produces = "application/json;charset=UTF-8")
//    public ResponseEntity<Object> deleteState(@PathVariable String code) {
//        stateService.delete(code);
//        return ResponseEntity.noContent().build();
//    }

}
