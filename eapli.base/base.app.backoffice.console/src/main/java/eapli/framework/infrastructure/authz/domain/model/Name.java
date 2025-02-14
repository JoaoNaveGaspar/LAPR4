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
package eapli.framework.infrastructure.authz.domain.model;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import lombok.Value;
import lombok.experimental.Accessors;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.regex.Pattern;

/**
 * A Person's name
 */
@Embeddable
@Value
@Accessors(fluent = true)
public class Name implements ValueObject, Serializable {

    private static final long serialVersionUID = 1L;

    @SuppressWarnings("squid:S4784")
    private static final Pattern VALID_NAME_REGEX = Pattern.compile("^[A-Z][a-zA-Z ',.\\-]*$",
            Pattern.CASE_INSENSITIVE);

    private final String firstName;
    private final String lastName;

    protected Name(final String firstName, final String lastName) {
        Preconditions.nonEmpty(firstName);
        Preconditions.nonEmpty(lastName, "First name and last name should neither be null nor empty");
        Preconditions.matches(VALID_NAME_REGEX, firstName, "Invalid First Name: " + firstName);
        Preconditions.matches(VALID_NAME_REGEX, lastName, "Invalid Last Name: " + lastName);

        this.firstName = firstName;
        this.lastName = lastName;
    }

    protected Name() {
        // ORM only
        firstName = lastName = "";
    }

    /**
     * builds a Name object
     *
     * @param firstName
     * @param lastName
     *
     * @return a Name
     */
    public static Name valueOf(final String firstName, final String lastName) {
        return new Name(firstName, lastName);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
