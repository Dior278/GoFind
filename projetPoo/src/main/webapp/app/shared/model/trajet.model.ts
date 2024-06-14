import dayjs from 'dayjs';
import { IApplicationUser } from 'app/shared/model/application-user.model';
import { IUtilisateur } from 'app/shared/model/utilisateur.model';

export interface ITrajet {
  id?: number;
  lieuDepart?: string;
  lieuArrivee?: string;
  dateDepart?: dayjs.Dayjs;
  heureDepart?: dayjs.Dayjs;
  placeDisp?: number;
  cheminPhotoVoiture?: string | null;
  conducteur?: string;
  listePassager?: string | null;
  applicationUser?: IApplicationUser | null;
  utilisateur?: IUtilisateur | null;
}

export const defaultValue: Readonly<ITrajet> = {};
