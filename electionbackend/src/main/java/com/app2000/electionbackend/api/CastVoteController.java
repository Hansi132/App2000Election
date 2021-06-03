package com.app2000.electionbackend.api;


import com.app2000.electionbackend.model.NominatedPerson;
import com.app2000.electionbackend.model.User;
import com.app2000.electionbackend.service.NominatedPersonService;
import com.app2000.electionbackend.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RequestMapping("/api/v1/castVote")
@RestController
@CrossOrigin
public class CastVoteController {

    private final UserService userService;
    private final NominatedPersonService nominatedPersonService;

    public CastVoteController(UserService userService, NominatedPersonService nominatedPersonService) {
        this.userService = userService;
        this.nominatedPersonService = nominatedPersonService;

    }

    @PostMapping
    public void castVote(@AuthenticationPrincipal OAuth2User principal, @RequestBody NominatedPerson nominatedPerson) throws SQLException {
        User votingUser = userService.selectOneUser(principal.getName());
        if (!votingUser.isHasVoted()) {
            if (nominatedPersonService.addVote(nominatedPerson)) {
                votingUser.setHasVoted(true);
                userService.updateVote(principal.getName(), votingUser);
            }
        }

    }
}
