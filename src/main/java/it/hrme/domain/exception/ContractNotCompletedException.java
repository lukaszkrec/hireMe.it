package it.hrme.domain.exception;

public class ContractNotCompletedException extends RuntimeException {
    public ContractNotCompletedException(String message) {
        super(message);
    }
}
