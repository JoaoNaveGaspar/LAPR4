/*
 * Copyright (c) 2013-2022 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package eapli.framework.domain.repositories;

/**
 * An abstraction to the actual transaction management mechanism.
 *
 * @author Paulo Gandra Sousa
 *
 */
public interface TransactionalContext {
    /**
     * Start a transaction in the persistence store.
     */
    void beginTransaction();

    /**
     * Commit changes to the persistence store.
     */
    void commit();

    /**
     * Rollback all changes from the beginning of the transaction.
     */
    void rollback();

    /**
     * Close the connection to the persistence store and rollback any pending
     * transaction.
     */
    void close();

    /**
     * Indicate whether a resource transaction is in progress. Checks if the
     * {@link #beginTransaction} method has been invoked.
     *
     * @return {@code true} if the transactional context is currently active.
     */
    boolean isActive();
}
