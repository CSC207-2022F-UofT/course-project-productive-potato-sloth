package useCases.CreateUser;

import gateways.UserDatabaseGateway;
import useCases.LoginPage.CreateAccountInputBoundary;
import useCases.LoginPage.CreateAccountPresenter;
import useCases.LoginPage.CreateAccountRequestModel;
import useCases.LoginPage.CreateAccountResponseModel;

public abstract class CreateUserInteractor implements CreateAccountInputBoundary {

        final UserDatabaseGateway gateway;
        final CreateAccountPresenter userPresenter;



        public CreateUserInteractor(UserDatabaseGateway gateway, CreateAccountPresenter userPresenter) {
                this.gateway = gateway;
                this.userPresenter = userPresenter;
        }

        public CreateAccountResponseModel create(CreateAccountRequestModel requestModel, String username) {
                return null;


//                if (gateway.get(username)) {
//                        return userPresenter.prepareFailureView("Username already exists.");
//                } else {
//                        gateway.insert(User.createUser);
//                }
//      }
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
        }
}
