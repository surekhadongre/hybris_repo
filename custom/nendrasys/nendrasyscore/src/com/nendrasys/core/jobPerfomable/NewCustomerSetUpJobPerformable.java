package com.nendrasys.core.jobPerfomable;

import com.nendrasys.core.service.NewCustomerService;
import de.hybris.platform.cms2.model.cronJobs.NewCustomerSetUpCronJobModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import de.hybris.platform.servicelayer.model.ModelService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewCustomerSetUpJobPerformable extends AbstractJobPerformable<NewCustomerSetUpCronJobModel> {
    private static final Logger LOG = Logger.getLogger(NewCustomerSetUpJobPerformable.class.getName());
    private NewCustomerService newCustomerService;

    protected NewCustomerService getNewCustomerService() {
        return this.newCustomerService;
    }

    @Required
    public void setNewCustomerService(final NewCustomerService newCustomerService) {
        this.newCustomerService = newCustomerService;
    }

    @Override
    public PerformResult perform(final NewCustomerSetUpCronJobModel cronJobModel) {
        final int lastCron= cronJobModel.getCronJobHistoryEntries().size();
        LOG.info("**********************************");
        LOG.info("!!!NewCustomerSetUpJobPerformable!!!");
        LOG.info("**********************************");
        if(cronJobModel.getCronJobHistoryEntries().get(lastCron-2).getEndTime()!=null)
            getNewCustomerService().getAllCustomers(cronJobModel.getCreationtime(),cronJobModel.getCronJobHistoryEntries().get(lastCron-2).getEndTime(),cronJobModel.getDaysToConsiderForNewCustomer());
        else
            getNewCustomerService().getAllCustomers(cronJobModel.getCreationtime(),new Date(),cronJobModel.getDaysToConsiderForNewCustomer());
        return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
    }


}
