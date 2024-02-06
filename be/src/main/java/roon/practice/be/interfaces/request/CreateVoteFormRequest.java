package roon.practice.be.interfaces.request;

import java.time.LocalDateTime;
import java.util.List;
import roon.practice.be.domain.vote.Option;


public record CreateVoteFormRequest(String title, String host, List<Option> optionList, LocalDateTime startAt, LocalDateTime endAt,
									boolean isMultiSelectable) {

}
