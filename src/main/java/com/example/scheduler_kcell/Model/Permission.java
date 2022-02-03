package com.example.scheduler_kcell.Model;

public enum Permission {
    Scheduler_READ("scheduler:read"),
    Scheduler_WRITE("scheduler:write");

    private final String permission;

    Permission(String permission){
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}