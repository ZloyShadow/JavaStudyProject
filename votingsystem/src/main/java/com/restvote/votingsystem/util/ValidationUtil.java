package com.restvote.votingsystem.util;

import com.restvote.votingsystem.model.MenuItem;
import com.restvote.votingsystem.model.Role;
import javassist.NotFoundException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class ValidationUtil {
    private static LocalTime timeVoteLimit = LocalTime.of(11, 0);

    // for testing purposes only
    public static void setTimeVoteLimit(LocalTime timeVoteLimit) {
        ValidationUtil.timeVoteLimit = timeVoteLimit;
    }

    public static void checkNotFoundWithId(boolean found, int id) {
        checkNotFound(found, "id=" + id);
    }

    public static <T> T checkNotFoundWithId(T object, int id) {
        return checkNotFound(object, "id=" + id);
    }

    public static <T> List<T> checkNotFoundWithId(List<T> list, int id) {
        return checkNotFound(list, "id=" + id);
    }

    public static <T> List<T> checkNotFoundByDate(List<T> list, LocalDate date) {
        return checkNotFound(list, "date=" + date);
    }

    public static void checkRole(Role actual, Role expected) {
        if (actual != expected) {
            throw new RuntimeException(String.format("Only user with role %s is allowed to modify data.", expected));
        }
    }

    public static void checkVoteTimeLimit(LocalDateTime taken) {
        if (taken.toLocalTime().isAfter(timeVoteLimit)) {
            throw new RuntimeException(String.format("You are allowed to vote until: %s", timeVoteLimit));
        }
    }

    public static void assureIdConsistent(MenuItem menuItem, int id) {
        if (menuItem.getId() != id) {
            throw new RuntimeException(String.format("%s must be with id=%d", menuItem, id));
        }
    }

    private static <T> T checkNotFound(T object, String msg) {
        checkNotFound(object != null, msg);
        return object;
    }



    private static void checkNotFound(boolean found, String msg) {
        if (!found) {
            throw new RuntimeException("Not found entity with " + msg);
        }
    }

    private static <T> List<T> checkNotFound(List<T> list, String msg) {
        checkNotFound(!list.isEmpty(), msg);
        return list;
    }
}
