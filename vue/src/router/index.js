import { createRouter as createRouter, createWebHistory } from 'vue-router'
import { useStore } from 'vuex'

// Import components
import HomeView from '../views/HomeView.vue';
import LoginView from '../views/LoginView.vue';
import LogoutView from '../views/LogoutView.vue';
import RegisterView from '../views/RegisterView.vue';
import AddBreweryView from '../views/AddBreweryView.vue'
import AddBeerView from '../views/AddBeerView.vue'
import BeerDetailsView from '../views/BeerDetailsView.vue';
import EditBeerView from '../views/EditBeerView.vue';
import NotFoundView from '../views/NotFoundView.vue';
import BeerListView from '../components/BeerList.vue';





/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */
const routes = [

  {
    path: "/not-found",
    name: "NotFoundView",
    component: NotFoundView
  },
  
  {
    path: '/',
    name: 'home',
    component: HomeView,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: "/login",
    name: "login",
    component: LoginView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/logout",
    name: "logout",
    component: LogoutView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/register",
    name: "register",
    component: RegisterView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/new_brewery",
    name: "AddBrewery",
    component: AddBreweryView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/add_beer",
    name: "AddBeer",
    component: AddBeerView,
    meta: {
      requiresAuth: false
    }
  },

  {
    path: '/beers',
    name: 'BeerListView',
    component: BeerListView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: '/beers/:beerId',
    name: 'BeerDetailsView',
    component: BeerDetailsView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: '/beers/create',
    name: 'AddBeerView',
    component: AddBeerView,
    meta: {
      requiresAuth: false
    }
    
  },
  {
    path: '/beers/:beerId/edit',
    name: 'EditBeerView',
    component: EditBeerView,
    meta: {
      requiresAuth: false
    }
  },
  // {
  //   path: '/brewery/:breweryId/beers/:beerId',
  //   name: 'BeerDetailsView',
  //   component: BeerDetailsView,
  //   meta: {
  //     requiresAuth: false
  //   }
  // },
  // {
  //   path: '/topic/:breweryId/beers/create',
  //   name: 'AddBeerView',
  //   component: AddBeerView,
  //   meta: {
  //     requiresAuth: false
  //   }
  // },
  // {
  //   path: '/brewery/:breweryId/beers/:beerId/edit',
  //   name: 'EditBeerView',
  //   component: EditBeerView,
  //       meta: {
  //     requiresAuth: false
  //   }
  // },


];

// Create the router
const router = createRouter({
  history: createWebHistory(),
  routes: routes
});

router.beforeEach((to) => {

  // Get the Vuex store
  const store = useStore();

  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    return {name: "login"};
  }
  // Otherwise, do nothing and they'll go to their next destination
});

export default router;
