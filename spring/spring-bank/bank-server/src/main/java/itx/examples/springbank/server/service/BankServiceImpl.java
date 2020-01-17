package itx.examples.springbank.server.service;

import itx.examples.springbank.common.dto.Client;
import itx.examples.springbank.common.dto.ClientId;
import itx.examples.springbank.common.dto.DepositRequest;
import itx.examples.springbank.common.dto.ServiceException;
import itx.examples.springbank.common.dto.TransactionRequest;
import itx.examples.springbank.common.dto.WithdrawRequest;
import org.springframework.stereotype.Service;

@Service
public class BankServiceImpl implements BankService {

    @Override
    public void transferFunds(TransactionRequest transactionRequest) throws ServiceException {

    }

    @Override
    public void deposit(DepositRequest depositRequest) throws ServiceException {

    }

    @Override
    public void withDraw(WithdrawRequest withdrawRequest) throws ServiceException {

    }

    @Override
    public Client getClientInfo(ClientId clientId) throws ServiceException {
        return null;
    }

}