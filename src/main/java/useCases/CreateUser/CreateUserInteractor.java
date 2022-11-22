package useCases.CreateUser;

import gateways.UserDatabaseGateway;
import useCases.LoginPage.CreateAccountInputBoundary;
import useCases.LoginPage.CreateAccountPresenter;
import useCases.LoginPage.CreateAccountRequestModel;
import useCases.LoginPage.CreateAccountResponseModel;

public class CreateUserInteractor implements CreateAccountInputBoundary {

        final UserDatabaseGateway gateway;
        final CreateAccountPresenter userPresenter;



        public CreateUserInteractor(UserDatabaseGateway gateway, CreateAccountPresenter userPresenter) {
                this.gateway = gateway;
                this.userPresenter = userPresenter;
        }

        @Override
        public CreateAccountResponseModel create(CreateAccountRequestModel requestModel) {
                return null;
        }

//        @Override
//        public CreateAccountResponseModel create(CreateAccountRequestModel requestModel) {
//                if (gateway.get() {
//                        return userPresenter.prepareFailureView("User already exists.");
//                } else if (!requestModel.getPassword().equals(requestModel.getRepeatPassword())) {
//                        return userPresenter.prepareFailureView("Passwords don't match.");
//                }
//
//                User user = userFactory.create(requestModel.getName(), requestModel.getPassword());
//                if (!user.passwordIsValid()) {
//                        return userPresenter.prepareFailureView("User password must have more than 5 characters.");
//                }
//
//                LocalDateTime now = LocalDateTime.now();
//                UserRegisterDsRequestModel userDsModel = new UserRegisterDsRequestModel(user.getName(), user.getPassword(), now);
//                userDsGateway.save(userDsModel);
//
//                UserRegisterResponseModel accountResponseModel = new UserRegisterResponseModel(user.getName(), now.toString());
//                return userPresenter.prepareSuccessView(accountResponseModel);
//        }
}
