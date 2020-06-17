package com.nendrasys.core.jobPerfomable;

import de.hybris.platform.cms2.model.cronJobs.HelloWorldCronJobModel;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import org.apache.log4j.Logger;

public class MyJobPerformable extends AbstractJobPerformable<HelloWorldCronJobModel> {

    private static final Logger LOG = Logger.getLogger(MyJobPerformable.class.getName());


    @Override
    public PerformResult perform(final HelloWorldCronJobModel helloWorldCronJobModel) {
        LOG.info("**********************************");
        LOG.info("Greeting from MyJobPerformable!!!");
        LOG.info("**********************************");
        System.out.println("<<<<<<<<<<<<<<<<...MyJobPerformable Cron Job.......>>>>>>>>>>>"+helloWorldCronJobModel.getEndTime());
        return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
    }
}
