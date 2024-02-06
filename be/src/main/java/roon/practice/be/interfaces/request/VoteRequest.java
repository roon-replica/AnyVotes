package roon.practice.be.interfaces.request;

import java.time.LocalDateTime;
import java.util.List;
import roon.practice.be.domain.vote.Option;

public record VoteRequest(String voteFormId, List<Option> selectedOptions, LocalDateTime voteAt) {

}
