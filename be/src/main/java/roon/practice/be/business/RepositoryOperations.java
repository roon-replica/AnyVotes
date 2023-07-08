package roon.practice.be.business;

public interface RepositoryOperations<T, Id> {

	Id id();

	T save(T t);

	void delete(T t);
}
