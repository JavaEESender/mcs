/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.obolon.ponovoy.impl;

import ua.obolon.ponovoy.inerfaces.Call;

/**
 *
 * @author Alexander
 */
public class Call_Impl implements Call {

    private String number;
    private long date;

    @Override
    public Call setNumber(String number) {
        this.number = number;
        return this;
    }

    @Override
    public Call setDate(long date) {
        this.date = date;
        return this;
    }

    @Override
    public long getDate() {
        return this.date;
    }

    @Override
    public String getNumber() {
        return this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Call_Impl call_ = (Call_Impl) o;

        if (date != call_.date) return false;
        return number != null ? number.equals(call_.number) : call_.number == null;

    }

    @Override
    public int hashCode() {
        int result = number != null ? number.hashCode() : 0;
        result = 31 * result + (int) (date ^ (date >>> 32));
        return result;
    }
}