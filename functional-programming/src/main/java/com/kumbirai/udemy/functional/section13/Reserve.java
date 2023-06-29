package com.kumbirai.udemy.functional.section13;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public class Reserve
{
    private static final Logger LOG = LoggerFactory.getLogger(Reserve.class);
    private final LocalDate prevResdate;
    private LocalDate resDate;

    public Reserve(LocalDate ResDate)
    {
        this.prevResdate = ResDate;
        this.resDate = ResDate;
    }

    public LocalDate getResDate()
    {
        return resDate;
    }

    public void setResDate(LocalDate resDate)
    {
        if (prevResdate.compareTo(resDate) == 0)
        {
            LOG.info("Date already reserved!");
        } else
        {
            this.resDate = resDate;
        }
    }
}
